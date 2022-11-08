const getUserId = (state) => state.auth?.auth?.user?.id;
const getAuthToken = (state) => state.auth?.auth?.authToken;
const getChats = (state) => state.user?.user;
// const getChatId= (state) => state.user?.user?.map(({id}) => id);

const userSelectors = {
  getUserId, getAuthToken, getChats,
};

export default userSelectors;
