import CryptoProvider from "./provider/CryptoProvider.js"
import PortfolioProvider from "./provider/PortfolioProvider.js"

new Vue({
    el: "#portfolio-table",
    data: {
        cryptos: [],
        portfolioItems: []
    },
    methods: {
        async getPortfolioItems(){
            let portfolioItems = await PortfolioProvider.getPortfolioItems()
            if (portfolioItems) {
                this.portfolioItems = portfolioItems
            }
        },
        async getCryptos(){
            let cryptos = await CryptoProvider.getCryptos()
            if (cryptos) {
                this.cryptos = cryptos
            }
        }
    },
    created(){
        this.getCryptos()
        this.getPortfolioItems()
    }
})