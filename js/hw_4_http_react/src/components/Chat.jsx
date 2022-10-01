import React from 'react'
//queries
import { getChatMessages, setChatMessages } from '../queries/queries';
//components
import Message from './Message';

const Chat = ({ userName }) => {
    const [chat, setChat] = React.useState([]);
    const [message, setMessage] = React.useState("")


    React.useEffect(() => {
        try {
            getChatMessages().then(setChat)

            const test = setInterval(() => {
                getChatMessages().then(setChat)
            }, 2000)

            return () => clearInterval(test)
        } catch (error) {
            console.log(error)
        }
    }, [])

    React.useEffect(() => {
        window.scrollTo({ left: 0, top: document.body.scrollHeight, behavior: "smooth" });
    }, [chat])


    const handleMessageSubmission = async (e) => {
        e.preventDefault();

        if (message.trim()) {
            await setChatMessages(userName, message)
            setMessage("")
        }
    }

    return (
        <div className="container">
            <div className="chat" >
                {chat?.map((item, index) => {
                    return <Message
                        key={index + item.date}
                        userName={item.user}
                        message={item.message}
                        date={item.date}
                    />
                })}
            </div>
            <form
                className="formMessage form"
                onSubmit={handleMessageSubmission}
            >
                <input
                    type="text"
                    placeholder="text your message"
                    onChange={(e) => setMessage(e.target.value)}
                    value={message}
                />
            </form>
        </div>
    )
}

export default Chat