const getAdmin = (state) => state.auth?.auth?.isAdmin;
const getUsername = (state) => state.auth?.auth?.user?.username;
const getLogin = (state) => state.auth?.isLogin;
const getError = (state) => state.auth?.error;
const authSelectors = { getAdmin, getUsername, getLogin, getError };

export default authSelectors;
