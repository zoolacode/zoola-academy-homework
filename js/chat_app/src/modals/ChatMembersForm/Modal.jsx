import React, { useState, useEffect, useMemo } from 'react';
import AvatarGroup from '@mui/material/AvatarGroup';
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

  // TODO: check why it's not updating
  const membersData = useMemo(() => allUsers?.filter((user) => membersIds?.includes(user.id)), [membersIds, allUsers]);

  // TODO: refactoring when chat list will be done
  useEffect(() => {
    const chatId = 'd49fa7a4-e2b3-4835-a975-b0e761ff6329';
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
      <AvatarGroup
        sx={{
          cursor: 'pointer'
        }}
        onClick={handleClickOpen}
        max={5}
      >
        {membersData?.map((user) => (
          <MemberAvatar key={user.id} username={user.username} />
        ))}
      </AvatarGroup>
      <MemberList open={open} onClose={handleClose} membersData={membersData} allUsers={allUsers} />
    </div>
  );
}
