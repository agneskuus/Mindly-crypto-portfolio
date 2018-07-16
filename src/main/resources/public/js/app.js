import CryptoProvider from "./provider/CryptoProvider.js"
import PortfolioProvider from "./provider/PortfolioProvider.js"

new Vue({
    el: "#portfolio-table",
    data: {
        cryptos: [],
        portfolio: [],
        newPortfolioItem: {}
    },
    methods: {
        async getPortfolioItems(){
            let portfolioItems = await PortfolioProvider.getPortfolioItems()
            if (portfolioItems) {
                this.portfolio = portfolioItems
            }
        },
        async getCryptos(){
            let cryptos = await CryptoProvider.getCryptos()
            if (cryptos) {
                this.cryptos = cryptos
                this.newPortfolioItem.crypto = cryptos[0]
            }
        },
        async createPortfolioItem(){
            let createdItem = await PortfolioProvider.createPortfolioItem(this.newPortfolioItem)
            if (createdItem) {
                this.portfolio.push(createdItem)
                this.newPortfolioItem = {}
            }
        }
    },
    created(){
        this.getCryptos()
        this.getPortfolioItems()
    }
})