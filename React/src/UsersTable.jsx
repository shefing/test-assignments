import React, { useMemo, useEffect, useState } from 'react';
import {
  MaterialReactTable,
  useMaterialReactTable,
} from 'material-react-table';
import Grid from '@mui/material/Grid';
import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import UsersPosts from './UsersPosts';



const UsersTable = () => {
  const [data, setData] = useState([]);
  const [posts, setPosts] = useState([]);
  const [rowSelection, setRowSelection] = useState({});
  const [displayPosts, setDisplayPosts] = useState(false);
  const [userId, setUserId] = useState(-1);
  const [loading, setLoading] = useState(false);
  const [hasError, setError] = useState(false);
  const [errorText, setErrorText] = useState("");

  const columns = useMemo(
    () => [
      {
        accessorKey: 'name',
        header: 'Name',
      },
	  {
        accessorKey: 'email',
        header: 'Email',
      },
	  {
        accessorKey: 'company.name',
        header: 'Company Name',
        enableColumnFilter : false
      },     
    ],
    [],
  );
  
  const handleError = (error) => {
	  setError(true);
	  setErrorText(error.message);
	  setLoading(false);
  }
  
  const table = useMaterialReactTable({
    columns,
    data,
	enableRowSelection: true,
	enableMultiRowSelection: false,
    initialState: { showColumnFilters: true },
	onRowSelectionChange: setRowSelection,
	state: { rowSelection }
  }) 
  
 
  useEffect(() => {
	    setLoading(true);
		fetch('https://jsonplaceholder.typicode.com/users')
		 .then((response) => response.json())
		 .then((json) => {setData(json);setLoading(false)})
		 .catch((error) => {handleError(error)});
	}, []);
	
  useEffect(() => {
    if (Object.keys(rowSelection).length > 0) {
		var id = Object.keys(rowSelection)[0];
		setLoading(true);
		fetch(`https://jsonplaceholder.typicode.com/posts?userId=${id}`)
		 .then((response) => response.json())
		 .then((json) => {setPosts(json);setDisplayPosts(true);setUserId(id);setLoading(false)})
		 .catch((error) => {handleError(error)});
	} else {		
		setDisplayPosts(false);
	}
  }, [rowSelection]);
	
  
  return (
	<Grid container spacing={2}>
		<Grid item sm={6}>
			<MaterialReactTable table={table} />
		</Grid>
		<Grid item sm={6}>
			{displayPosts && <UsersPosts posts={posts} id={userId}/>}
		</Grid>

		{loading && <Box sx={{ display: 'flex' }}>
						<CircularProgress />
				   </Box>}
		{hasError && <Stack sx={{ width: '100%' }} spacing={2}>      
					<Alert severity="error">{errorText}</Alert>
				  </Stack>}
	</Grid>
  );
};

export default UsersTable

