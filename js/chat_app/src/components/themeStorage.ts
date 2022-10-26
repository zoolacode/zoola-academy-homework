export const get = (name: string) => {
  return JSON.parse(sessionStorage.getItem(name)!);
};

export const set = (name: string,item: any) => {
 return sessionStorage.setItem(name, JSON.stringify(item));
};
