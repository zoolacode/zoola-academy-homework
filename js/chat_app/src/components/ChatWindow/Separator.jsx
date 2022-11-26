import React, { useState, useEffect } from 'react';
import Timeline from '@mui/lab/Timeline';
import TimelineItem from '@mui/lab/TimelineItem';
import TimelineSeparator from '@mui/lab/TimelineSeparator';
import TimelineConnector from '@mui/lab/TimelineConnector';
import TimelineContent from '@mui/lab/TimelineContent';
import TimelineDot from '@mui/lab/TimelineDot';
import Typography from '@mui/material/Typography';
import TimelineOppositeContent from '@mui/lab/TimelineOppositeContent';
import { useDispatch } from 'react-redux';
import { getUserByIdThunk } from '../../redux/chat/slice';
import Image from '../ChatImageUpload/Image';

function Separator({ date, authId, message }) {
  const [user, setUser] = useState();
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getUserByIdThunk(authId)).then((res) => setUser(res.payload));
  }, []);

  const options = {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
  };

  return (
    <Timeline>
      <TimelineItem>
        <TimelineOppositeContent>
          {message?.attachment
            ? <Image attachment={message.attachment} />
            : message.message}
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot />
          <TimelineConnector />
        </TimelineSeparator>
        <TimelineContent color="textSecondary">
          <Typography>{user ? user.username : ''}</Typography>
          <Typography>
            {new Date(date).toLocaleDateString('en-GB', options)}
          </Typography>
        </TimelineContent>
      </TimelineItem>
    </Timeline>
  );
}

export default Separator;
