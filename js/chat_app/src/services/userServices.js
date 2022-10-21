export const userServices = {
  getAllUsers: async (authToken) => {
    try {
      const data = await fetch('/api/users', {
        method: 'GET',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        }
      });

      const response = data.json();

      return response;
    } catch (error) {
      console.log(error);
    }
  },
  createUser: async (authToken, username, password, adminId) => {
    try {
      await fetch('/api/users', {
        method: 'POST',
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
        body: JSON.stringify({
          adminId,
          username,
          password
        })
      });
    } catch (error) {
      console.log(error);
    }
  }
};
