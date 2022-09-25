export function getCellStyle(item, indexX, indexY) {
  return item.some(([x, y]) => x === indexX && y === indexY);
}
