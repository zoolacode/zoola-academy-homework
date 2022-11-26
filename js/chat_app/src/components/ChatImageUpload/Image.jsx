import { Box } from '@mui/material';
import React from 'react';

export default function Image({ attachment }) {
  return (
    <Box>
      <img
        src={`uploads/${attachment}`}
        height={140}
        width="auto"
        alt="uploads"
      />
    </Box>
  );
}
