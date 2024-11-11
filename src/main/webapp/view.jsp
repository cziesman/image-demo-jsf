<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<html xmlns:h="http://www.w3.org/1999/html">
<head>
    <title>Display Image from DB demo</title>
</head>

<body>
<f:view>
    <h:form>
        <h:dataTable id="table" value="#{displayImageBean.images}" var="curr">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Index"/>
                </f:facet>
                <h:outputText value="#{curr.index}"/>
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Name"/>
                </f:facet>
                <h:outputText value="#{curr.name}"/>
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Image"/>
                </f:facet>
                <h:graphicImage value="#{displayImageBean.encodedImage(curr.index)}"/>
            </h:column>
        </h:dataTable>
    </h:form>
</f:view>
</body>
</html>