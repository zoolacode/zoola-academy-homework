export const set = (session) => {
  localStorage.setItem("session", JSON.stringify(session));
};

export const get = () => {
  const sessionJSON = localStorage.getItem("session");
  if (!sessionJSON) {
    return null;
  }
  try {
    return JSON.parse(sessionJSON);
  } catch (err) {
    return null;
  }
};

export const getCurrentUser = () => {
  const session = get();

  if (!session) {
    return null;
  }

  return {
    id: session.user.id,
    username: session.user.username,
  };
};

export const getAuthToken = () => {
  const session = get();
  return session?.authToken ?? null;
};
