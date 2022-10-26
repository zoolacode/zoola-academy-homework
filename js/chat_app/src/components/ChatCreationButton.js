import React, { useEffect, useState } from 'react';
import {
    Box,
    TextField,
    MenuItem,
    Select,
    InputLabel,
    FormControl,
    OutlinedInput,
    Button,
    DialogTitle,
    Dialog
} from '@mui/material'

function fetchCreateChatWithMembers(ChatName, token, personName) {
    return fetch("/api/chats", {
        method: "post",
        body: JSON.stringify({ title: ChatName }),
        headers: {
            "content-type": "application/json",
            "auth-token": `${token}`
        },
    }).then((response) => response.json()).then(date => date.id).then(date => {
        return fetch(`/api/chats/${date}/members`, {
            method: "post",
            body: JSON.stringify({ members: personName }), //
            headers: {
                "content-type": "application/json",
                "auth-token": `${token}`
            },
        }).then((r) => r.json()).then(d => d)
    })
}
function fetchGetUsers(token) {
    return fetch(`/api/users/`, {
        method: "get",
        headers: {
            "content-type": "application/json",
            "auth-token": `${token}`
        }
    }).then((response) => response.json())
        .then((date) => date)
}

export default function ChatCreationButton(props) {
    const { auth } = props

    const [open, setOpen] = useState(false);
    const [users, setUsers] = useState([])
    useEffect(() => {
        fetchGetUsers(auth.authToken).then((date) => setUsers(date))
    }, [open])

    const [selectedUsers, setselectedUsers] = useState([]);
    const handleChangeSelect = (event) => {
        const {
            target: { value },
        } = event;
        setselectedUsers(
            typeof value === 'string' ? value.split(',') : value,
        );
    };

    const [chatName, setChatName] = useState("")
    const handleChatName = (event) => {
        setChatName(event.target.value)
    }

    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
        setChatName("")
        setselectedUsers([])
    };
    const handleSubmit = () => {
        fetchCreateChatWithMembers(chatName, auth.authToken, selectedUsers).then(() => {
            handleClose();
        });
    }



    return (
        <>
            <Button variant="outlined" onClick={handleClickOpen}>
                Create New Chat
            </Button>
            
            <Dialog sx={{ m: 2, overflow: "hidden" }} onClose={handleClose} open={open}>
                <DialogTitle sx={{ minWidth: 300 }} >Create new chat</DialogTitle>
                <Box sx={{ p: 3 }} >
                    <TextField
                        fullWidth
                        label="Chat name"
                        onChange={handleChatName}
                    ></TextField>
                    <br />
                    <br />
                    <FormControl fullWidth sx={{ mb: 7 }}>
                        <InputLabel id="demo-multiple-name-label">Members</InputLabel>
                        <Select
                            labelId="demo-multiple-name-label"
                            id="demo-multiple-name"
                            multiple
                            value={selectedUsers}
                            onChange={handleChangeSelect}
                            input={<OutlinedInput label="Members" />} 
                        >
                            {
                                users.map((el, i) => {
                                    if (el.username !== "admin") return <MenuItem key={i} value={el.id}>{el.username}</MenuItem>
                                })
                            }

                        </Select>
                    </FormControl>
                    <Button sx={{ m: 3, position: "absolute", right: 0, bottom: -3 }} onClick={handleSubmit} variant="outlined">Create</Button>
                </Box>
            </Dialog>
        </>
    );
}










