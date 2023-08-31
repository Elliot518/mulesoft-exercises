[Back](../README.md)

## Secure Configuration Properties

<hr>


MuleSoft Secure Properties Tools: <br />
<a href="https://docs.mulesoft.com/mule-runtime/4.4/_attachments/secure-properties-tool.jar">Secure Properties Tool Jar file</a>

<hr>

### 1. What is MuleSoft

#### 1-1) Encrypt Yaml File

- java command
  ```shell
  java -cp secure-properties-tool.jar com.mulesoft.tools.SecurePropertiesTool \
  file \
  encrypt \
  Blowfish \
  CBC \
  mulesoft \
  example_in.yaml \
  example_out.yaml
  ```

- example_in.yaml
  ```yaml
  properties:
  example1:
    value: "Muleman is here"
  example2: "Max the mule"
  ```

- example_out.yaml
  ```yaml
  properties:
  example1:
    value: "![qCReIPK3jcqD7WR84ISSIQ==]"
  example2: "![En8lII21ZHrdIaINw0+mSA==]"
  ```

<hr>

#### 1-2) Encrypt Properties File

- java command
  ```shell
  java -cp secure-properties-tool.jar com.mulesoft.tools.SecurePropertiesTool \
  file \
  encrypt \
  Blowfish \
  CBC \
  mulesoft \
  example_in.properties \
  example_out.properties
  ```

- example_in.properties
  ```properties
  properties.example1.value=Muleman is here
  properties.example2=Max the mule
  ```

- example_out.properties
  ```properties
  properties.example1.value=![qCReIPK3jcqD7WR84ISSIQ==]
  properties.example2=![En8lII21ZHrdIaINw0+mSA==]
  ```
