const getChatData = (state) => state.chat?.chatData;
const getStatus = (state) => state.chat?.status;
const getError = (state) => state.chat?.isError;
const chatSelectors = {
  getChatData,
  getStatus,
  getError
};

export default chatSelectors;
