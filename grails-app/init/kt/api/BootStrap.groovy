package kt.api

import kt.api.auth.*
import kt.api.data.*

class BootStrap {

	def springSecurityService

    def init = { servletContext ->
    	for (String url in [
			'/', '/error', '/index', '/index.gsp', '/**/favicon.ico', '/shutdown',
			'/**/js/**', '/**/css/**', '/**/images/**',
			'/api/login']) {
		 	new Requestmap(url: url, configAttribute: 'permitAll').save()
		}
		// new Requestmap(url: '/welcome/**', configAttribute: 'isAuthenticated()').save()
		for (String url in ['/api/logout', '/api/product']) {
		 	new Requestmap(url: url, configAttribute: 'isAuthenticated()').save()
		}
		
		springSecurityService.clearCachedRequestmaps()


    	def role1 = new Role(authority:"ROLE_ADMIN").save flush:true
		def user1 = new User(username:"admin", password:"1234").save flush:true
		UserRole.create(user1, role1)

		def role2 = new Role(authority:"ROLE_USER").save flush:true
		def user2 = new User(username:"user", password:"1234").save flush:true
		UserRole.create(user2, role2)

		def prod1 = new Product(prodName:"iPhone 7",prodDesc:"New iPhone 7 32GB",prodPrice:780).save flush:true
      	def prod2 = new Product(prodName:"iPhone 7 Plus",prodDesc:"New iPhone 7 Plus 128GB",prodPrice:990).save flush:true
      	def prod3 = new Product(prodName:"iPhone 7 SE",prodDesc:"New iPhone 7 SE 64GB",prodPrice:520).save flush:true
    }
    def destroy = {
    }
}
