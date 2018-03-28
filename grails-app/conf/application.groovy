

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'kt.api.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'kt.api.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'kt.api.auth.Role'
// grails.plugin.springsecurity.requestMap.className = 'kt.api.auth.Requestmap'
// grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'

// grails.plugin.springsecurity.rest.login.active = true
// grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
// grails.plugin.springsecurity.rest.login.failureStatusCode = 401
// grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
// grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'

grails.plugin.springsecurity.contrillerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	// [pattern: '/api/login', 	 access: ['permitAll']],
	// [pattern: '/api/login/**', 	 access: ['permitAll']],
	// [pattern: '/api/logout', 	 access: ['permitAll']],
	[pattern: '/api/**', 	access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
    //Stateless chain
    [
        pattern: '/api/**',
        filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
    ],

    //Traditional chain
    [
        pattern: '/**',
        filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
    ]
]

grails.plugin.springsecurity.rest.login.active = true
grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.login.failureStatusCode = '403'
grails.plugin.springsecurity.rest.login.useRequestParamsCredentials = false
grails.plugin.springsecurity.rest.login.useJsonCredentials = true
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'username'
grails.plugin.springsecurity.rest.login.passwordPropertyName = 'password'


grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'

grails.plugin.springsecurity.rest.token.generation.useSecureRandom = true
grails.plugin.springsecurity.rest.token.generation.useUUID = false

grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'kt.api.auth.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = 'tokenValue'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'username'


