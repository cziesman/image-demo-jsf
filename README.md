# image demo

### Assuming that the image is displayed in a table row

#### Replace

    <a4j:mediaOutput 
        element="img" 
        cacheable="false"
        session="false"
        createContent="#{questionMediaBean.paintPreview}"
        value="#{curr.referencedObject.mmId}" mimeType="image/jpeg"
        styleClass="thinDarkBorder" />

#### with 

    <h:graphicImage 
        value="#{displayImageBean.encodedImage(curr.index)}"
        styleClass="thinDarkBorder" />

