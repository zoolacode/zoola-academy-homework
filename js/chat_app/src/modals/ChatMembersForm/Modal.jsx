import React, { useState, useEffect, useMemo } from 'react';
import AvatarGroup from '@mui/material/AvatarGroup';
import IconButton from '@mui/material/IconButton';
import { useDispatch, useSelector } from 'react-redux';
import { getAllUsersThunk } from '../../redux/slices/usersSlice';
import { getChatByIdThunk } from '../../redux/slices/chatSlice';
import MemberAvatar from './MemberAvatar';
import MemberList from './MemberList';

export default function ChatMembersListModal() {
  const [open, setOpen] = useState(false);
  const dispatch = useDispatch();
  const membersIds = useSelector((state) => state.chat.chatData?.members);
  const allUsers = useSelector((state) => state.users?.allUsers);

  const membersData = useMemo(() => allUsers?.filter((user) => membersIds?.includes(user.id)), [allUsers]);

  // TODO: refactoring when chat list will be done
  useEffect(() => {
    const chatId = '9cea1435-00b1-4e86-9631-9040f0d5afc1';
    dispatch(getChatByIdThunk(chatId));
    dispatch(getAllUsersThunk());
  }, []);

  const handleClickOpen = () => {
    dispatch(getAllUsersThunk());
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <IconButton
        sx={{
          width: '100%'
        }}
        onClick={handleClickOpen}
      >
        <AvatarGroup max={5}>
          {membersData?.map((user) => (
            <MemberAvatar key={user.id} username={user.username} />
          ))}
        </AvatarGroup>
      </IconButton>
      <MemberList open={open} onClose={handleClose} membersData={membersData} allUsers={allUsers} />
    </div>
  );
}
