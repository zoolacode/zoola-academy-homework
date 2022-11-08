const getChatData = (state) => state.chat?.chatData;
const getStatus = (state) => state.chat?.status;
const getError = (state) => state.chat?.isError;
const getMembers = (state) => state.chat?.chatData?.members;
const getChatId = (state) => state.chat?.chatData.id;
const getSelectedMembers = (state) => state.chat?.selectedMembers;

const chatSelectors = {
  getChatData,
  getStatus,
  getError,
  getMembers,
  getChatId,
  getSelectedMembers
};

export default chatSelectors;
