package kt.api

import grails.core.GrailsApplication
import grails.plugins.*
import grails.plugin.springsecurity.annotation.Secured

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }
}
