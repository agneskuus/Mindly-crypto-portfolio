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
        async getPortfolioItems() {
            let portfolioItems = await PortfolioProvider.getPortfolioItems()
            if (portfolioItems) {
                this.portfolio = portfolioItems
            }
        },
        async getCryptos() {
            let cryptos = await CryptoProvider.getCryptos()
            if (cryptos) {
                this.cryptos = cryptos
                this.newPortfolioItem.crypto = cryptos[0]
            }
        },
        async createPortfolioItem() {
            let createdItem = await PortfolioProvider.createPortfolioItem(this.newPortfolioItem)
            if (createdItem) {
                this.portfolio.push(createdItem)
                this.newPortfolioItem = {}
            }
        },
        async deletePortfolioItem(item, index) {
            let didConfirm = confirm("Are you sure you want to delete this item?\n" + item.crypto.name
                + ", value: " + item.value + "€")
            if (didConfirm) {
                let deletedItem = await PortfolioProvider.deletePortfolioItem(item)
                if (deletedItem) {
                    Vue.delete(this.portfolio, index)
                }
                else {
                    alert("Failed to delete item")
                    this.getPortfolioItems()
                }
            }
        }
    },
    created(){
        this.getCryptos()
        this.getPortfolioItems()
    }
})