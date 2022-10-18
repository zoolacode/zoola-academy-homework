import { Avatar, Box, Stack, Typography } from "@mui/material";

export const UsersList = ({ users }) => {
    
  return (
    <Box>
      <Stack spacing={1}>
        {users.map((user) => {
          return (
            <Box key={user.id}>
              <Stack sx={{ alignItems: "center" }} direction="row">
                <Avatar>{user.username[0]}</Avatar>
                <Box ml={2}>
                  <Typography>{user.username}</Typography>
                </Box>
              </Stack>
            </Box>
          );
        })}
      </Stack>
    </Box>
  );
};
