import { queryAuth } from './utils/utils';

const login = async ({ username, password }) => {
  const body = {
    username,
    password,
  };
  const response = await queryAuth('/api/login', 'POST', body);
  return response;
};

export default login;
