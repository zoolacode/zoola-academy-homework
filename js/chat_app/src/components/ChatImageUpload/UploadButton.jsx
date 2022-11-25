import React from 'react';
import IconButton from '@mui/material/IconButton';
import AttachFileIcon from '@mui/icons-material/AttachFile';
import Stack from '@mui/material/Stack';
import { useDispatch } from 'react-redux';
import { sendUploadsByChatIdThunk } from '../../redux/chat/slice';

export default function UploadButton() {
  const dispatch = useDispatch();
  function hendleChangeInput(e) {
    const file = e.target.files[0];
    dispatch(sendUploadsByChatIdThunk(file));
  }
  return (
    <Stack
      direction="row"
      justifyContent="flex-end"
      alignItems="center"
      spacing={1}
    >
      <IconButton color="primary" aria-label="upload picture" component="label">
        <input hidden accept="image/*" type="file" onChange={hendleChangeInput} />
        <AttachFileIcon />
      </IconButton>
    </Stack>
  );
}
