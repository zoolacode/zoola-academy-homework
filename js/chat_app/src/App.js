import './App.css';
import React from "react";
import { ChatList } from './ChatList';

function App() {
  const [chatId, setChatID] = React.useState(null);


  return (
    <div className="App">
      <ChatList chatId={chatId} setChatID={setChatID}/>
    </div>
  );
}

export default App;
