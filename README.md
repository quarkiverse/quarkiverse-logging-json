[![Maven Central](https://img.shields.io/maven-central/v/io.quarkiverse.loggingjson/quarkiverse-logging-json?logo=apache-maven&style=for-the-badge)](https://search.maven.org/artifact/io.quarkiverse.loggingjson/quarkiverse-logging-json)
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->
# Quarkiverse Logging Json
Quarkus logging extension outputting the logging in json.

# Configuration
The extension is enabled by default, when added to the project.
Can be disabled using configuration: `quarkus.log.console.json=false`

To see additional configuration options take a look at [Config](runtime/src/main/java/io/quarkiverse/loggingjson/Config.java)

# Add additional fields to all log messages
If you want to add a static field to all the log message, that is possible using the configuration.
```properties
quarkus.log.console.json.additional-field.serviceName.value=service-a
# type is by default STRING - Other is INT, LONG, FLOAT, DOUBLE 
quarkus.log.console.json.additional-field.buildNumber.type=INT
quarkus.log.console.json.additional-field.buildNumber.value=42
```

# Structured argument
If you want to do structured logging of arguments, then the argument send with your logging, can implement `io.quarkus.logging.json.structured.StructuredArgument`. Then it is possible to use the JsonGenerator to format the argument in json. 

## Simple usage
```java
import static io.quarkus.logging.json.structured.KeyValueStructuredArgument.*;
...
log.info("Test log of structured arg", kv("key", "value"));
```
# Custom log handler
If you want to add your own custom way to handle the LogRecords.
You can create your own implementations of `io.quarkiverse.loggingjson.JsonProvider`, and provide it using CDI.
Example implementation:
```java
import io.quarkiverse.loggingjson.JsonProvider;

public class MyJsonProvider implements JsonProvider {

    void writeTo(JsonGenerator generator, ExtLogRecord event) throws IOException {
        generator.writeStringField("myCustomField", "and my custom value"); // Will be added to every log, as a field on the json.
    }
}
```

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://github.com/SlyngDK"><img src="https://avatars2.githubusercontent.com/u/6666094?v=4" width="100px;" alt=""/><br /><sub><b>Simon Bengtsson</b></sub></a><br /><a href="https://github.com/quarkiverse/quarkiverse-logging-json/commits?author=SlyngDK" title="Code">💻</a> <a href="#maintenance-SlyngDK" title="Maintenance">🚧</a></td>
  </tr>
</table>

<!-- markdownlint-enable -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!