import * as React from "react";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import MenuItem from "@mui/material/MenuItem";
import MenuList from "@mui/material/MenuList";

//hardcode
const allChats = [
  {
    id: "064ff14f-0dab-47d4-bd88-5fd0799fe982",
    members: [
      "fhs8dhf9s8dhf9sd8hf9sd8hf",
      "d692d442-e576-46ce-9d66-8838d1dc9ff3",
      "f81cfa12-1e12-4a45-a3ac-26710b9c43d5",
    ],
    messages: [
      {
        id: "5327afd0-4a12-11ed-9964-19e32f619c00",
        message: "hi",
        authorId: "fhs8dhf9s8dhf9sd8hf9sd8hf",
        date: 1665567808333,
      },
      {
        id: "561b4d50-4a12-11ed-9964-19e32f619c00",
        message: "bkhb",
        authorId: "fhs8dhf9s8dhf9sd8hf9sd8hf",
        date: 1665567813285,
      },
      {
        id: "9df99640-4a12-11ed-9964-19e32f619c00",
        message: "ghvk",
        authorId: "fhs8dhf9s8dhf9sd8hf9sd8hf",
        date: 1665567933860,
      },
    ],
    title: "nick-tick",
  },
  {
    id: "69ae8235-7b4c-4ef9-b8b9-532ba46640cb",
    members: [
      "fhs8dhf9s8dhf9sd8hf9sd8hf",
      "f81cfa12-1e12-4a45-a3ac-26710b9c43d5",
      "d692d442-e576-46ce-9d66-8838d1dc9ff3",
    ],
    messages: [],
    title: "With nick",
  },
  {
    id: "ca074a0d-bd4e-473a-b326-81b19fa9a5bb",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "194fdb30-32b5-4b09-84fc-927cb4478bb8",
    members: [],
    messages: [],
    title: "second",
  },
  {
    id: "3a01baba-7d40-4f0b-9880-edab180176cf",
    members: ["66fff54f-6bbc-4092-8f8f-8e08b00a47fc"],
    messages: [],
    title: "first",
  },
  {
    id: "af533959-4c36-46d0-bb95-70cd02107677",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "fcd13317-d0a2-42fe-b7e9-a2adf49bf7f5",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "e5738fc1-329c-4cf1-8a30-5f92e64b7f2a",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "905b4734-34ba-42c1-a375-8d3976fdb9b9",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "5286eb66-603e-47e3-8486-e3adefbd2e5f",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "56fed65f-bbe4-45ca-8d87-58de6c59f235",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "caa747f2-fb35-4040-9225-89e604e92696",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "7d0f5810-f510-4bf3-b159-21d593ffbbfa",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "df50b132-4e5b-4779-bfa7-43030b989885",
    members: [],
    messages: [],
    title: "first",
  },
  {
    id: "db3c53fa-721d-4d38-91f6-2b38b2b1db86",
    members: [],
    messages: [],
    title: "first",
  },
];

const userId = "fhs8dhf9s8dhf9sd8hf9sd8hf",
  authToken = "c4a6ee4f-b87b-4390-88ae-e068237aad89";

//component
export default function ChatList({ onSelectChat }) {
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
    },
  })
    .then((response) => response.json())
    .then((response) => setChatsData(response));

  React.useEffect(() => {}, []);

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
