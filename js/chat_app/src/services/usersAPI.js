export const usersAPI = {
  getAllUsers: async () => {
    try {
      const query = await fetch('/api/users', {
        method: 'GET',
        headers: {
          'content-type': 'application/json'
        }
      });

      return JSON.parse(query.json());
    } catch (error) {
      console.log(error);
    }
  }
};
