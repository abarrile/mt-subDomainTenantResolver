package kt.api.data

import grails.rest.*
import grails.plugin.springsecurity.annotation.Secured

@Resource(uri='/api/product')
@Secured(['ROLE_USER'])
class Product {

    String prodName
    String prodDesc
    Double prodPrice
    Date createDate = new Date()

    static constraints = {
    }
}