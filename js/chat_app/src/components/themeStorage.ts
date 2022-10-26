export const getStorage = (name: string) => {
  return JSON.parse(sessionStorage.getItem(name)!);
};

export const setStorage = (name: string,item: any) => {
 return sessionStorage.setItem(name, JSON.stringify(item));
};
