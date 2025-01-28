package com.wayoukiss.android.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.wayoukiss.android.data.local.dao.ChatDao;
import com.wayoukiss.android.data.local.dao.ChatDao_Impl;
import com.wayoukiss.android.data.local.dao.MatchDao;
import com.wayoukiss.android.data.local.dao.MatchDao_Impl;
import com.wayoukiss.android.data.local.dao.ProfileDao;
import com.wayoukiss.android.data.local.dao.ProfileDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WayouKissDatabase_Impl extends WayouKissDatabase {
  private volatile ProfileDao _profileDao;

  private volatile MatchDao _matchDao;

  private volatile ChatDao _chatDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `profiles` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `bio` TEXT, `birthDate` INTEGER NOT NULL, `photos` TEXT NOT NULL, `lastActive` INTEGER NOT NULL, `isOnline` INTEGER NOT NULL, `location` TEXT, `interests` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `matches` (`id` TEXT NOT NULL, `user1Id` TEXT NOT NULL, `user2Id` TEXT NOT NULL, `matchedAt` INTEGER NOT NULL, `lastInteractionAt` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`user1Id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`user2Id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_matches_user1Id` ON `matches` (`user1Id`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_matches_user2Id` ON `matches` (`user2Id`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `chats` (`id` TEXT NOT NULL, `matchId` TEXT NOT NULL, `lastMessageAt` INTEGER, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`matchId`) REFERENCES `matches`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_chats_matchId` ON `chats` (`matchId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `messages` (`id` TEXT NOT NULL, `chatId` TEXT NOT NULL, `senderId` TEXT NOT NULL, `content` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`chatId`) REFERENCES `chats`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`senderId`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_chatId` ON `messages` (`chatId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_senderId` ON `messages` (`senderId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f43e2d8859227c655d618d5b7b55cb51')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `profiles`");
        db.execSQL("DROP TABLE IF EXISTS `matches`");
        db.execSQL("DROP TABLE IF EXISTS `chats`");
        db.execSQL("DROP TABLE IF EXISTS `messages`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsProfiles = new HashMap<String, TableInfo.Column>(11);
        _columnsProfiles.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("bio", new TableInfo.Column("bio", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("birthDate", new TableInfo.Column("birthDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("photos", new TableInfo.Column("photos", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("lastActive", new TableInfo.Column("lastActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("isOnline", new TableInfo.Column("isOnline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("interests", new TableInfo.Column("interests", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfiles.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProfiles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProfiles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProfiles = new TableInfo("profiles", _columnsProfiles, _foreignKeysProfiles, _indicesProfiles);
        final TableInfo _existingProfiles = TableInfo.read(db, "profiles");
        if (!_infoProfiles.equals(_existingProfiles)) {
          return new RoomOpenHelper.ValidationResult(false, "profiles(com.wayoukiss.android.data.local.entity.ProfileEntity).\n"
                  + " Expected:\n" + _infoProfiles + "\n"
                  + " Found:\n" + _existingProfiles);
        }
        final HashMap<String, TableInfo.Column> _columnsMatches = new HashMap<String, TableInfo.Column>(6);
        _columnsMatches.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("user1Id", new TableInfo.Column("user1Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("user2Id", new TableInfo.Column("user2Id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("matchedAt", new TableInfo.Column("matchedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("lastInteractionAt", new TableInfo.Column("lastInteractionAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMatches = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysMatches.add(new TableInfo.ForeignKey("profiles", "CASCADE", "NO ACTION", Arrays.asList("user1Id"), Arrays.asList("id")));
        _foreignKeysMatches.add(new TableInfo.ForeignKey("profiles", "CASCADE", "NO ACTION", Arrays.asList("user2Id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMatches = new HashSet<TableInfo.Index>(2);
        _indicesMatches.add(new TableInfo.Index("index_matches_user1Id", false, Arrays.asList("user1Id"), Arrays.asList("ASC")));
        _indicesMatches.add(new TableInfo.Index("index_matches_user2Id", false, Arrays.asList("user2Id"), Arrays.asList("ASC")));
        final TableInfo _infoMatches = new TableInfo("matches", _columnsMatches, _foreignKeysMatches, _indicesMatches);
        final TableInfo _existingMatches = TableInfo.read(db, "matches");
        if (!_infoMatches.equals(_existingMatches)) {
          return new RoomOpenHelper.ValidationResult(false, "matches(com.wayoukiss.android.data.local.entity.MatchEntity).\n"
                  + " Expected:\n" + _infoMatches + "\n"
                  + " Found:\n" + _existingMatches);
        }
        final HashMap<String, TableInfo.Column> _columnsChats = new HashMap<String, TableInfo.Column>(5);
        _columnsChats.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChats.put("matchId", new TableInfo.Column("matchId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChats.put("lastMessageAt", new TableInfo.Column("lastMessageAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChats.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChats.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChats = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChats.add(new TableInfo.ForeignKey("matches", "CASCADE", "NO ACTION", Arrays.asList("matchId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChats = new HashSet<TableInfo.Index>(1);
        _indicesChats.add(new TableInfo.Index("index_chats_matchId", false, Arrays.asList("matchId"), Arrays.asList("ASC")));
        final TableInfo _infoChats = new TableInfo("chats", _columnsChats, _foreignKeysChats, _indicesChats);
        final TableInfo _existingChats = TableInfo.read(db, "chats");
        if (!_infoChats.equals(_existingChats)) {
          return new RoomOpenHelper.ValidationResult(false, "chats(com.wayoukiss.android.data.local.entity.ChatEntity).\n"
                  + " Expected:\n" + _infoChats + "\n"
                  + " Found:\n" + _existingChats);
        }
        final HashMap<String, TableInfo.Column> _columnsMessages = new HashMap<String, TableInfo.Column>(8);
        _columnsMessages.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("chatId", new TableInfo.Column("chatId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("senderId", new TableInfo.Column("senderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessages = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysMessages.add(new TableInfo.ForeignKey("chats", "CASCADE", "NO ACTION", Arrays.asList("chatId"), Arrays.asList("id")));
        _foreignKeysMessages.add(new TableInfo.ForeignKey("profiles", "CASCADE", "NO ACTION", Arrays.asList("senderId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMessages = new HashSet<TableInfo.Index>(2);
        _indicesMessages.add(new TableInfo.Index("index_messages_chatId", false, Arrays.asList("chatId"), Arrays.asList("ASC")));
        _indicesMessages.add(new TableInfo.Index("index_messages_senderId", false, Arrays.asList("senderId"), Arrays.asList("ASC")));
        final TableInfo _infoMessages = new TableInfo("messages", _columnsMessages, _foreignKeysMessages, _indicesMessages);
        final TableInfo _existingMessages = TableInfo.read(db, "messages");
        if (!_infoMessages.equals(_existingMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "messages(com.wayoukiss.android.data.local.entity.MessageEntity).\n"
                  + " Expected:\n" + _infoMessages + "\n"
                  + " Found:\n" + _existingMessages);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f43e2d8859227c655d618d5b7b55cb51", "d6cd93e3001d2221bb449a4cc3c30299");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "profiles","matches","chats","messages");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `profiles`");
      _db.execSQL("DELETE FROM `matches`");
      _db.execSQL("DELETE FROM `chats`");
      _db.execSQL("DELETE FROM `messages`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProfileDao.class, ProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MatchDao.class, MatchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChatDao.class, ChatDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ProfileDao profileDao() {
    if (_profileDao != null) {
      return _profileDao;
    } else {
      synchronized(this) {
        if(_profileDao == null) {
          _profileDao = new ProfileDao_Impl(this);
        }
        return _profileDao;
      }
    }
  }

  @Override
  public MatchDao matchDao() {
    if (_matchDao != null) {
      return _matchDao;
    } else {
      synchronized(this) {
        if(_matchDao == null) {
          _matchDao = new MatchDao_Impl(this);
        }
        return _matchDao;
      }
    }
  }

  @Override
  public ChatDao chatDao() {
    if (_chatDao != null) {
      return _chatDao;
    } else {
      synchronized(this) {
        if(_chatDao == null) {
          _chatDao = new ChatDao_Impl(this);
        }
        return _chatDao;
      }
    }
  }
}
