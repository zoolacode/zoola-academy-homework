const getChatData = (state) => state.chat?.chatData;
const getStatus = (state) => state.chat?.status;
const getError = (state) => state.chat?.isError;
const getChatId = (state) => state.chat?.chatData?.id;
const chatSelectors = {
  getChatData,
  getStatus,
  getError,
  getChatId
};

export default chatSelectors;
