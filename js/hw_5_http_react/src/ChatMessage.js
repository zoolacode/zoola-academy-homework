import React from "react";
import {
  TimelineConnector,
  TimelineContent,
  TimelineDot,
  TimelineItem,
  TimelineOppositeContent,
  TimelineSeparator,
} from "@mui/lab";
import { Typography } from "@mui/material";

export const ChatMessage = ({ users, message, isLast, onPreview }) => {
  const author = users[message.authorId];
  const date = new Date(message.date).toLocaleTimeString();
  const time = new Date(message.date).toLocaleDateString();

  return (
    <TimelineItem>
      <TimelineOppositeContent>
        {message.attachment ? (
          <>
            <div
              style={{ cursor: "pointer" }}
              onClick={() => onPreview(message.attachment)}
            >
              <img
                alt="preview"
                className="attachment-preview"
                src={`/uploads/${message.attachment}`}
              />
            </div>
          </>
        ) : (
          <Typography variant="body1">{message.message}</Typography>
        )}
      </TimelineOppositeContent>

      <TimelineSeparator>
        <TimelineDot />
        {!isLast && <TimelineConnector />}
      </TimelineSeparator>
      <TimelineContent style={{ color: "grey" }}>
        <Typography variant="body2">{author.username}</Typography>
        <Typography variant="caption">
          {time}/{date}
        </Typography>
      </TimelineContent>
    </TimelineItem>
  );
};
