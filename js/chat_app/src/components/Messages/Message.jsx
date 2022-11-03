import { CircularProgress } from "@mui/material";
import {
  Timeline,
  TimelineItem,
  TimelineSeparator,
  TimelineConnector,
  TimelineContent,
  TimelineDot,
  TimelineOppositeContent,
} from "@mui/lab";

export const Messages = ({ messagesList, usersList }) => {
  const getUserName = (array, messageItem) => {
    const items = array.find((item) => item.id === messageItem.authorId);
    return items.username;
  };
  
  return (
    <Timeline>
      {messagesList
        .slice(0)
        .reverse()
        .map((messageItem, index) => (
          <TimelineItem key={messageItem.id}>
            <TimelineOppositeContent>
              {messageItem.message}
            </TimelineOppositeContent>
            <TimelineSeparator>
              <TimelineDot />
              {!(index === messagesList.length - 1) && <TimelineConnector />}
            </TimelineSeparator>
            <TimelineContent color="text.secondary">
              {getUserName(usersList, messageItem)}
              <br />
              {`${new Date(messageItem.date).toLocaleDateString()}`}/
              {`${new Date(messageItem.date).toLocaleTimeString()}`}
            </TimelineContent>
          </TimelineItem>
        )) ?? <CircularProgress />}
    </Timeline>
  );
};
