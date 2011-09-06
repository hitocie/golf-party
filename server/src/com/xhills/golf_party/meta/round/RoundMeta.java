package com.xhills.golf_party.meta.round;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-06 18:28:10")
/** */
public final class RoundMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.round.Round> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Course>, com.xhills.golf_party.model.course.Course> courseRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Course>, com.xhills.golf_party.model.course.Course>(this, "courseRef", "courseRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.course.Course.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, java.util.Date> date = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, java.util.Date>(this, "date", "date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half> firstHalfRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half>(this, "firstHalfRef", "firstHalfRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.course.Half.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half> lastHalfRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Round, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half>(this, "lastHalfRef", "lastHalfRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.course.Half.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.xhills.golf_party.common.course.Weather> weather = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.xhills.golf_party.common.course.Weather>(this, "weather", "weather", com.xhills.golf_party.common.course.Weather.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.xhills.golf_party.common.course.Wind> wind = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Round, com.xhills.golf_party.common.course.Wind>(this, "wind", "wind", com.xhills.golf_party.common.course.Wind.class);

    private static final RoundMeta slim3_singleton = new RoundMeta();

    /**
     * @return the singleton
     */
    public static RoundMeta get() {
       return slim3_singleton;
    }

    /** */
    public RoundMeta() {
        super("Round", com.xhills.golf_party.model.round.Round.class);
    }

    @Override
    public com.xhills.golf_party.model.round.Round entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.round.Round model = new com.xhills.golf_party.model.round.Round();
        if (model.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) is null.");
        }
        model.getCourseRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("courseRef"));
        model.setDate((java.util.Date) entity.getProperty("date"));
        if (model.getFirstHalfRef() == null) {
            throw new NullPointerException("The property(firstHalfRef) is null.");
        }
        model.getFirstHalfRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("firstHalfRef"));
        model.setKey(entity.getKey());
        if (model.getLastHalfRef() == null) {
            throw new NullPointerException("The property(lastHalfRef) is null.");
        }
        model.getLastHalfRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("lastHalfRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setWeather(stringToEnum(com.xhills.golf_party.common.course.Weather.class, (java.lang.String) entity.getProperty("weather")));
        model.setWind(stringToEnum(com.xhills.golf_party.common.course.Wind.class, (java.lang.String) entity.getProperty("wind")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) must not be null.");
        }
        entity.setProperty("courseRef", m.getCourseRef().getKey());
        entity.setProperty("date", m.getDate());
        if (m.getFirstHalfRef() == null) {
            throw new NullPointerException("The property(firstHalfRef) must not be null.");
        }
        entity.setProperty("firstHalfRef", m.getFirstHalfRef().getKey());
        if (m.getLastHalfRef() == null) {
            throw new NullPointerException("The property(lastHalfRef) must not be null.");
        }
        entity.setProperty("lastHalfRef", m.getLastHalfRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("weather", enumToString(m.getWeather()));
        entity.setProperty("wind", enumToString(m.getWind()));
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        if (m.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) must not be null.");
        }
        m.getCourseRef().assignKeyIfNecessary(ds);
        if (m.getFirstHalfRef() == null) {
            throw new NullPointerException("The property(firstHalfRef) must not be null.");
        }
        m.getFirstHalfRef().assignKeyIfNecessary(ds);
        if (m.getLastHalfRef() == null) {
            throw new NullPointerException("The property(lastHalfRef) must not be null.");
        }
        m.getLastHalfRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.round.Round m = (com.xhills.golf_party.model.round.Round) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCourseRef() != null && m.getCourseRef().getKey() != null){
            writer.setNextPropertyName("courseRef");
            encoder0.encode(writer, m.getCourseRef(), maxDepth, currentDepth);
        }
        if(m.getDate() != null){
            writer.setNextPropertyName("date");
            encoder0.encode(writer, m.getDate());
        }
        if(m.getFirstHalfRef() != null && m.getFirstHalfRef().getKey() != null){
            writer.setNextPropertyName("firstHalfRef");
            encoder0.encode(writer, m.getFirstHalfRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastHalfRef() != null && m.getLastHalfRef().getKey() != null){
            writer.setNextPropertyName("lastHalfRef");
            encoder0.encode(writer, m.getLastHalfRef(), maxDepth, currentDepth);
        }
        if(m.getRoundGroupRef() != null){
            writer.setNextPropertyName("roundGroupRef");
            encoder0.encode(writer, m.getRoundGroupRef());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        if(m.getWeather() != null){
            writer.setNextPropertyName("weather");
            encoder0.encode(writer, m.getWeather());
        }
        if(m.getWind() != null){
            writer.setNextPropertyName("wind");
            encoder0.encode(writer, m.getWind());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.round.Round jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.round.Round m = new com.xhills.golf_party.model.round.Round();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("courseRef");
        decoder0.decode(reader, m.getCourseRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("date");
        m.setDate(decoder0.decode(reader, m.getDate()));
        reader = rootReader.newObjectReader("firstHalfRef");
        decoder0.decode(reader, m.getFirstHalfRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastHalfRef");
        decoder0.decode(reader, m.getLastHalfRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("roundGroupRef");
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("weather");
        m.setWeather(decoder0.decode(reader, m.getWeather(), com.xhills.golf_party.common.course.Weather.class));
        reader = rootReader.newObjectReader("wind");
        m.setWind(decoder0.decode(reader, m.getWind(), com.xhills.golf_party.common.course.Wind.class));
        return m;
    }
}