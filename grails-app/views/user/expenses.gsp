<!DOCTYPE html>


<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>

    <body>
        <g:form name="login" style="margin: 0 auto; width:320px">
            <h1>name</h1>
            <g:textField name="myField" value="${myValue}" />
            <h1>balance</h1>
            <g:textField name="myField" value="${myValue}" /><br/><br/>
            <g:actionSubmit value="Calculate expense" action="update" />
        </g:form>
    </body>
</html>