import React from 'react';
import IconButton from '@mui/material/IconButton';
import AttachFileIcon from '@mui/icons-material/AttachFile';
import Stack from '@mui/material/Stack';

export default function UploadButton() {
  return (
    <Stack
      direction="row"
      justifyContent="flex-end"
      alignItems="center"
      spacing={1}
    >
      <IconButton color="primary" aria-label="upload picture" component="label">
        <input hidden accept="image/*" type="file" />
        <AttachFileIcon />
      </IconButton>
    </Stack>
  );
}
