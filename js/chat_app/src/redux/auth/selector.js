const getAdmin = (state) => state.auth?.auth?.isAdmin;
const getUsername = (state) => state.auth?.auth?.user?.username;
const getLogin = (state) => state.auth?.isLogin;
const getError = (state) => state.auth?.error;
const getAuthToken = (state) => state.auth?.auth?.authToken;
const getAuthUserId = (state) => state.auth?.auth?.user?.id;

const authSelectors = {
  getAdmin,
  getUsername,
  getLogin,
  getError,
  getAuthToken,
  getAuthUserId
};

export default authSelectors;
