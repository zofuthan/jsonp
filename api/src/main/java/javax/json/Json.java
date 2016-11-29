/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2016 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.json;

import javax.json.spi.JsonProvider;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Factory class for creating JSON processing objects.
 * This class provides the most commonly used methods for creating these
 * objects and their corresponding factories. The factory classes provide
 * all the various ways to create these objects.
 *
 * <p>
 * The methods in this class locate a provider instance using the method
 * {@link JsonProvider#provider()}. This class uses the provider instance
 * to create JSON processing objects.
 *
 * <p>
 * The following example shows how to create a JSON parser to parse
 * an empty array:
 * <pre>
 * <code>
 * StringReader reader = new StringReader("[]");
 * JsonParser parser = Json.createParser(reader);
 * </code>
 * </pre>
 *
 * <p>
 * All the methods in this class are safe for use by multiple concurrent
 * threads.
 */
public final class Json {

    private Json() {
    }

    /**
     * Creates a JSON parser from a character stream.
     *
     * @param reader i/o reader from which JSON is to be read
     * @return a JSON parser
     */
    public static JsonParser createParser(Reader reader) {
        return JsonProvider.provider().createParser(reader);
    }

    /**
     * Creates a JSON parser from a byte stream.
     * The character encoding of the stream is determined as specified in 
     * <a href="http://tools.ietf.org/rfc/rfc7159.txt">RFC 7159</a>.
     *
     * @param in i/o stream from which JSON is to be read
     * @throws JsonException if encoding cannot be determined
     *         or i/o error (IOException would be cause of JsonException)
     * @return a JSON parser
     */
    public static JsonParser createParser(InputStream in) {
        return JsonProvider.provider().createParser(in);
    }

    /**
     * Creates a JSON generator for writing JSON to a character stream.
     *
     * @param writer a i/o writer to which JSON is written
     * @return a JSON generator
     */
    public static JsonGenerator createGenerator(Writer writer) {
        return JsonProvider.provider().createGenerator(writer);
    }

    /**
     * Creates a JSON generator for writing JSON to a byte stream.
     *
     * @param out i/o stream to which JSON is written
     * @return a JSON generator
     */
    public static JsonGenerator createGenerator(OutputStream out) {
        return JsonProvider.provider().createGenerator(out);
    }

    /**
     * Creates a parser factory for creating {@link JsonParser} objects.
     *
     * @return JSON parser factory.
     *
    public static JsonParserFactory createParserFactory() {
        return JsonProvider.provider().createParserFactory();
    }
     */

    /**
     * Creates a parser factory for creating {@link JsonParser} objects.
     * The factory is configured with the specified map of provider specific
     * configuration properties. Provider implementations should ignore any
     * unsupported configuration properties specified in the map.
     *
     * @param config a map of provider specific properties to configure the
     *               JSON parsers. The map may be empty or null
     * @return JSON parser factory
     */
    public static JsonParserFactory createParserFactory(Map<String, ?> config) {
        return JsonProvider.provider().createParserFactory(config);
    }

    /**
     * Creates a generator factory for creating {@link JsonGenerator} objects.
     *
     * @return JSON generator factory
     *
    public static JsonGeneratorFactory createGeneratorFactory() {
        return JsonProvider.provider().createGeneratorFactory();
    }
    */

    /**
     * Creates a generator factory for creating {@link JsonGenerator} objects.
     * The factory is configured with the specified map of provider specific
     * configuration properties. Provider implementations should ignore any
     * unsupported configuration properties specified in the map.
     *
     * @param config a map of provider specific properties to configure the
     *               JSON generators. The map may be empty or null
     * @return JSON generator factory
     */
    public static JsonGeneratorFactory createGeneratorFactory(
            Map<String, ?> config) {
        return JsonProvider.provider().createGeneratorFactory(config);
    }

    /**
     * Creates a JSON writer to write a
     * JSON {@link JsonObject object} or {@link JsonArray array}
     * structure to the specified character stream.
     *
     * @param writer to which JSON object or array is written
     * @return a JSON writer
     */
    public static JsonWriter createWriter(Writer writer) {
        return JsonProvider.provider().createWriter(writer);
    }

    /**
     * Creates a JSON writer to write a
     * JSON {@link JsonObject object} or {@link JsonArray array}
     * structure to the specified byte stream. Characters written to
     * the stream are encoded into bytes using UTF-8 encoding.
     *
     * @param out to which JSON object or array is written
     * @return a JSON writer
     */
    public static JsonWriter createWriter(OutputStream out) {
        return JsonProvider.provider().createWriter(out);
    }

    /**
     * Creates a JSON reader from a character stream.
     *
     * @param reader a reader from which JSON is to be read
     * @return a JSON reader
     */
    public static JsonReader createReader(Reader reader) {
        return JsonProvider.provider().createReader(reader);
    }

    /**
     * Creates a JSON reader from a byte stream. The character encoding of
     * the stream is determined as described in
     * <a href="http://tools.ietf.org/rfc/rfc7159.txt">RFC 7159</a>.
     *
     * @param in a byte stream from which JSON is to be read
     * @return a JSON reader
     */
    public static JsonReader createReader(InputStream in) {
        return JsonProvider.provider().createReader(in);
    }

    /**
     * Creates a reader factory for creating {@link JsonReader} objects.
     * The factory is configured with the specified map of provider specific
     * configuration properties. Provider implementations should ignore any
     * unsupported configuration properties specified in the map.
     *
     * @param config a map of provider specific properties to configure the
     *               JSON readers. The map may be empty or null
     * @return a JSON reader factory
     */
    public static JsonReaderFactory createReaderFactory(Map<String, ?> config) {
        return JsonProvider.provider().createReaderFactory(config);
    }

    /**
     * Creates a writer factory for creating {@link JsonWriter} objects.
     * The factory is configured with the specified map of provider specific
     * configuration properties. Provider implementations should ignore any
     * unsupported configuration properties specified in the map.
     *
     * @param config a map of provider specific properties to configure the
     *               JSON writers. The map may be empty or null
     * @return a JSON writer factory
     */
    public static JsonWriterFactory createWriterFactory(Map<String, ?> config) {
        return JsonProvider.provider().createWriterFactory(config);
    }

    /**
     * Creates a JSON array builder
     *
     * @return a JSON array builder
     */
    public static JsonArrayBuilder createArrayBuilder() {
        return JsonProvider.provider().createArrayBuilder();
    }

    /**
     * Creates a JSON array builder, initialized with the specified array
     *
     * @param array the initial array in the builder
     * @return a JSON array builder
     *
     * @since 1.1
     */
    public static JsonArrayBuilder createArrayBuilder(JsonArray array) {
        return JsonProvider.provider().createArrayBuilder(array);
    }

    /**
     * Creates a JSON array builder, initialized with the specified array
     *
     * @param collection the initial array in the builder
     * @return a JSON array builder
     *
     * @since 1.1
     */
    public static JsonArrayBuilder createArrayBuilder(Collection<Object> collection) {
        return JsonProvider.provider().createArrayBuilder(collection);
    }

    /**
     * Creates a JSON object builder
     *
     * @return a JSON object builder
     */
    public static JsonObjectBuilder createObjectBuilder() {
        return JsonProvider.provider().createObjectBuilder();
    }

    /**
     * Creates a JSON object builder, initialized with the specified object.
     *
     * @param object the initial object in the builder
     * @return a JSON object builder
     *
     * @since 1.1
     */
    public static JsonObjectBuilder createObjectBuilder(JsonObject object) {
        return JsonProvider.provider().createObjectBuilder(object);
    }

    /**
     * Creates a JSON object builder, initialized with the specified object.
     *
     * @param object the initial object in the builder
     * @return a JSON object builder
     *
     * @since 1.1
     */
    public static JsonObjectBuilder createObjectBuilder(Map<String, Object> object) {
        return JsonProvider.provider().createObjectBuilder(object);
    }

    /**
     * Creates JSON Pointer (<a href="http://tools.ietf.org/html/rfc6901">RFC 6901</a>)
     * from given {@code jsonPointer} string.
     * <ul>
     *     <li>An empty {@code jsonPointer} string defines a reference to the target itself.</li>
     *     <li>If the {@code jsonPointer} string is non-empty, it must be a sequence of '/' prefixed tokens.</li>
     * </ul>
     *
     * @param jsonPointer the JSON Pointer string
     * @throws NullPointerException if {@code jsonPointer} is {@code null}
     * @throws JsonException if {@code jsonPointer} is not a valid JSON Pointer
     * @return JSON Pointer for {@code jsonPointer} string
     *
     * @since 1.1
     */
    public static JsonPointer createPointer(String jsonPointer) {
        return JsonProvider.provider().createPointer(jsonPointer);
    }

    /**
     * Creates a JSON Patch builder (<a href="http://tools.ietf.org/html/rfc6902">RFC 6902</a>).
     *
     * @return a JSON Patch builder
     *
     * @since 1.1
     */
    public static JsonPatchBuilder createPatchBuilder() {
        return JsonProvider.provider().createPatchBuilder();
    }

    /**
     * Creates a JSON Patch builder
     * (<a href="http://tools.ietf.org/html/rfc6902">RFC 6902</a>), initialized with the specified operations.
     *
     * @param array the initial patch operations
     * @return a JSON Patch builder
     *
     * @since 1.1
     */
    public static JsonPatchBuilder createPatchBuilder(JsonArray array) {
        return JsonProvider.provider().createPatchBuilder(array);
    }

    /**
     * Creates a JSON Patch from the {@code JsonArray}.
     *
     * @param array patch operations
     * @return a JSON Patch
     *
     * @since 1.1
     */
    public static JsonPatch createPatch(JsonArray array) {
        return JsonProvider.provider().createPatch(array);
    }

    /**
     * Generates a JSON Patch from the source and target {@code JsonStructure}.
     * The generated JSON Patch need not be unique.
     * @param source the source
     * @param target the target, must be the same type as the source
     * @return a JSON Patch which when applied to the source, yields the target
     *
     * @since 1.1
     */
    public static JsonPatch createDiff(JsonStructure source, JsonStructure target) {
        return JsonProvider.provider().createDiff(source, target);
    }

    /**
     * Applies the specified Json Merge Patch
     * <a href="http://tools.ietf.org/html/rfc7396">RFC 7396</a> to the specified target.
     * The target is not modified by the patch.
     *
     * @param target the {@code JsonValue} to apply the patch operations
     * @param patch the patch
     * @return the {@code JsonValue} as the result of applying the patch
     *    operations on the target.
     */
    public static JsonValue mergePatch(JsonValue target, JsonValue patch) {
        return JsonProvider.provider().mergePatch(target, patch);
    }

    /**
     * Generate a JSON Merge Patch from the source and target {@code JsonValue}.
     * @param source the source
     * @param target the target
     * @return a JSON Patch which when applied to the source, yields the target
     */
    public static JsonValue createMergePatch(JsonValue source, JsonValue target) {
        return JsonProvider.provider().createMergePatch(source, target);
    }

    /**
     * Creates a builder factory for creating {@link JsonArrayBuilder}
     * and {@link JsonObjectBuilder} objects.
     * The factory is configured with the specified map of provider specific
     * configuration properties. Provider implementations should ignore any
     * unsupported configuration properties specified in the map.
     *
     * @param config a map of provider specific properties to configure the
     *               JSON builders. The map may be empty or null
     * @return a JSON builder factory
     */
    public static JsonBuilderFactory createBuilderFactory(
            Map<String, ?> config) {
        return JsonProvider.provider().createBuilderFactory(config);
    }

    /**
     * Creates a JsonString
     *
     * @param value a JSON string
     * @return the JsonString for the string
     *
     * @since 1.1
     */
    public static JsonString createValue(String value) {
        return JsonProvider.provider().createValue(value);
    }

    /**
     * Creates a JsonNumber
     *
     * @param value a JSON number
     * @return the JsonNumber for the number
     *
     * @since 1.1
     */
    public static JsonNumber createValue(int value) {
        return JsonProvider.provider().createValue(value);
    }

    /**
     * Creates a JsonNumber
     *
     * @param value a JSON number
     * @return the JsonNumber for the number
     *
     * @since 1.1 
     */ 
    public static JsonNumber createValue(long value) {
        return JsonProvider.provider().createValue(value);
    }

    /**
     * Creates a JsonNumber
     *
     * @param value a JSON number
     * @return the JsonNumber for the number
     *
     * @since 1.1 
     */ 
    public static JsonNumber createValue(double value) {
        return JsonProvider.provider().createValue(value);
    }

    /**
     * Creates a JsonNumber
     *
     * @param value a JSON number
     * @return the JsonNumber for the number
     *
     * @since 1.1 
     */ 
    public static JsonNumber createValue(BigDecimal value) {
        return JsonProvider.provider().createValue(value);
    }

    /**
     * Creates a JsonNumber
     *
     * @param value a JSON number
     * @return the JsonNumber for the number
     *
     * @since 1.1 
     */ 
    public static JsonNumber createValue(BigInteger value) {
        return JsonProvider.provider().createValue(value);
    }
}
