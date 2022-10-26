import React from "react";
import { UserContext } from "./UserContext";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import MenuItem from "@mui/material/MenuItem";
import MenuList from "@mui/material/MenuList";

export const ChatList = ({ onSelectChat }) => {
  const [selectedId, setSelectedID] = React.useState(1);
  const [chatsData, setChatsData] = React.useState([]);
  const { auth } = useContext(UserContext);

  const userId = auth?.user.id;
  const authToken = auth?.authToken;


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
