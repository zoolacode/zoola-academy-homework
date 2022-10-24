import React from "react";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import MenuItem from "@mui/material/MenuItem";
import MenuList from "@mui/material/MenuList";

//temporary hardcode
{
  const userId = "fhs8dhf9s8dhf9sd8hf9sd8hf";
  const authToken = "c4a6ee4f-b87b-4390-88ae-e068237aad89";
}

export const function ChatList({ onSelectChat }) {
  const [selectedId, setSelectedID] = React.useState(1);
  const [chatsData, setChatsData] = React.useState([]);

  const handleChatListItemClick = (event, id) => {
    //`GET /api/chats/:chatId`
    // draw chat history use onSelectChat component
    setSelectedID(id);
  };

  fetch(`api/users/${userId}/chats`, {
    method: "GET",
    headers: {
      "auth-token": authToken,
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then(setChatsData);

  return (
    <Box sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}>
      <Paper>
        <MenuList>
          {chatsData.map((params) => {
            return (
              <MenuItem
                selected={selectedId === params.id}
                onClick={(event) => handleChatListItemClick(event, params.id)}
              >
                {params.title}
              </MenuItem>
            );
          })}
        </MenuList>
      </Paper>
    </Box>
  );
}
