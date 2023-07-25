package ru.qiwi.demo.Components;

import ru.qiwi.demo.Clients.CBRClient;

public class MainComponentBuilder {
    private CBRClient cbrClient;

    public MainComponentBuilder setCbrClient(CBRClient cbrClient) {
        this.cbrClient = cbrClient;
        return this;
    }

    public MainComponent createMainComponent() {
        return new MainComponent(cbrClient);
    }
}