import {
  amber,
  blueGrey,
  deepOrange,
  deepPurple,
  lightBlue,
} from "@mui/material/colors";

export function getAvatarColor(index) {
  const max = 5;
  const colors = [deepOrange, deepPurple, lightBlue, blueGrey, amber];
  return colors[index % max][500];
}
