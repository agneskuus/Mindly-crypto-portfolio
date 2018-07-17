import service from "../service/NetworkingService.js"

export default {
    async getPortfolioItems() {
        try {
            let response = await service.get("/api/portfolio")
            return response.data
        }
        catch(error) {
            console.log(error)
        }
    },
    async createPortfolioItem(portfolioItem) {
        try {
            let response = await service.post("/api/portfolio", portfolioItem)
            return response.data
        } catch(error) {
            console.log(error)
        }
    },
    async deletePortfolioItem(item) {
        try {
            let response = await service.delete("/api/portfolio/" + (item.id))
            return response.data
        } catch(error) {
            console.log(error)
        }
    }

}
