const chatURL = "/api/chat"

export const getChatMessages = async () => {
    try {
        const query = await fetch(chatURL, {
            method: "GET",
            headers: {
                "content-type": "application/json",
            }
        })

        return query.json()
    } catch (error) {
        console.log(error)
    }
}

export const setChatMessages = async (userName, message) => {
    try {
        const date = new Date().toLocaleString('en-US', {weekday:"short", hour: '2-digit', hour12: true, minute:'2-digit'})
        const query = await fetch(chatURL, {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify({ user: userName, message, date })
        })

        return query.json()
    } catch (error) {
        console.log(error)
    }
}