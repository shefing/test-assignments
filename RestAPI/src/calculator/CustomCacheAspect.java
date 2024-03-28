package calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomCacheAspect {

    @Autowired
    private CacheManager cacheManager;

    @Around("@annotation(customCacheable)")
    public Object cacheResult(ProceedingJoinPoint joinPoint, CustomCacheable customCacheable) throws Throwable {    	
        String cacheName = customCacheable.cacheName();
        if (cacheName.isEmpty()) {
            throw new IllegalArgumentException("Cache name must be provided");
        }

        Cache cache = cacheManager.getCache(cacheName);

        // Generate cache key based on method arguments
        Object[] args = joinPoint.getArgs();
        StringBuilder cacheKeyBuilder = new StringBuilder(joinPoint.getSignature().toLongString());
        for (Object arg : args) {
            cacheKeyBuilder.append(arg.toString());
        }
        String cacheKey = cacheKeyBuilder.toString();

        // Check if the result is already cached
        Cache.ValueWrapper valueWrapper = cache.get(cacheKey);
        if (valueWrapper != null) {
            return valueWrapper.get();
        }

        // Proceed with the method execution and cache the result
        Object result = joinPoint.proceed();
        cache.put(cacheKey, result);
        return result;
    }
}
