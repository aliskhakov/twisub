function initTwisubNotifications () {
    if (!("Notification" in window)) {
        console.log("This browser does not support desktop notification.");
    } else if (Notification.permission === "granted") {
        initTwisubSseNotifications();
    } else if (Notification.permission !== 'denied') {
        Notification.requestPermission(function (permission) {
            if (permission === "granted") {
                let notification = new Notification("Hi there!");
                initTwisubSseNotifications();
            }
        });
    }
}

function initTwisubSseNotifications() {
    const eventSource = new EventSource(/*[[${url}]]*/);
    eventSource.addEventListener('message', event => {
        let text = JSON.parse(event.data).text;
        let notification = new Notification(`New tweets: ${text}`);
    });
}

initTwisubNotifications();
