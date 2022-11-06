import {
    fetchRequestJSON
} from "./fetch";

export const login = (data) => {
    return fetchRequestJSON({
        url: "/api/login",
        method: "POST",
        data
    });
};

export const createChat = (data, token) => {
    return fetchRequestJSON({
        url: "/api/chats",
        method: "POST",
        authToken: token,
        data
    });
};

export const getChatsByUserId = (token, userId) => {
    return fetchRequestJSON({
        url: `api/users/${userId}/chats`,
        authToken: token
    });
};

export const createUser = (data, token) => {
    return fetchRequestJSON({
        url: "/api/users",
        method: "POST",
        authToken: token,
        data
    });
};

export const getUsers = (token) => {
    return fetchRequestJSON({
        url: "/api/users",
        authToken: token
    });
};

export const addChatMembers = (token, chatId, data) => {
    return fetchRequestJSON({
        url: `/api/chats/${chatId}/members`,
        method: "POST",
        authToken: token,
        data
    });
};

export const getChatById = (token, chatId) => {
    return fetchRequestJSON({
        url: `/api/chats/${chatId}`,
        authToken: token
    });
};

export const addChatMessage = (token, chatId, data) => {
    return fetchRequestJSON({
        url: `/api/chats/${chatId}/messages`,
        method: "POST",
        authToken: token,
        data
    });
};

export const uploadFileToChat = (token, chatId, data) => {
    const formData = new FormData();
    formData.append("file", data);
    formData.append("authorToken", token);
      
    return fetch(`/api/chats/${chatId}/attachments`, {
        method: "POST",
        body: formData,
        headers: {
            "auth-token": token
        }
    });
};
