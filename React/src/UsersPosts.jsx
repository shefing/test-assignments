import React, { useMemo, useEffect, useState } from 'react';
import {
  MaterialReactTable,
  useMaterialReactTable,
} from 'material-react-table';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';


const UsersPosts = ({posts, id}) => {
  
  const [data, setData] = useState([]);
  const [userId, setUserId] = useState(-1);
  const [open, setOpen] = useState(false);
  
  const columns = useMemo(
    () => [
      {
        accessorKey: 'title',
        header: 'Title',
      },
	  {
        accessorKey: 'body',
        header: 'Body',
      },   
    ],
    [],
  );
  
  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  
  const addPost = (post) => {
	  var copyPosts = [...data];
	  copyPosts.push(post);
	  setData([...copyPosts]);
	  handleClose();
  }
  
  useEffect(() => {
		setData([...posts]);
		setUserId(id);
	}, [posts]);
  
  var table = useMaterialReactTable({
    columns,
    data,
  }) 
  
  
  return (
	<Grid container spacing={2}>
		<Grid item sm={6}>
			<MaterialReactTable table={table} />
		</Grid>
		<Grid item sm={6}>
			<Button variant="outlined" onClick={handleClickOpen}>
			  Create post
			</Button>
		<Dialog
			open={open}
			onClose={handleClose}
			PaperProps={{
			component: 'form',
			onSubmit: (event) => {
				event.preventDefault();
				const formData = new FormData(event.currentTarget);
				var formJson = Object.fromEntries(formData.entries());
				formJson.userId = userId;
				fetch('https://jsonplaceholder.typicode.com/posts', {
					method: 'POST',
					body: JSON.stringify(formJson),
					headers: {
						'Content-type': 'application/json; charset=UTF-8',
					},
				})
				.then((response) => response.json())
				.then((json) => addPost(json));				
				},
			}}
		>
        <DialogTitle>Create post</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Please enter the title and body of the new post
          </DialogContentText>
          <TextField
            autoFocus
            required
            margin="dense"
            id="title"
            name="title"
            label="Title"            
            fullWidth
            variant="standard"
          />
		  <TextField            
            required
            margin="dense"
            id="body"
            name="body"
            label="Body"            
            fullWidth
            variant="standard"
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button type="submit">Create</Button>
        </DialogActions>
      </Dialog>
		</Grid>
	</Grid>
    );
};


export default UsersPosts;

