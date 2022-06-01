module.exports = {
  preset: '@vue/cli-plugin-unit-jest',
  setupFiles: ["<rootDir>/tests/unit/setup.js"]   ,
    "moduleFileExtensions": [
        "js",
        "jsx",
        "ts",
        "tsx"
    ],
    "moduleNameMapper": {
        "\\.(css|less|scss|sass|svg)$": "identity-obj-proxy",
        "^components/(.*)$": "<rootDir>/src/components/$1",
        "^assets/(.*)$": "<rootDir>/src/assets/$1",
        "^utils/(.*)$": "<rootDir>/src/utils/$1",
        "^styles/(.*)$": "<rootDir>/src/styles/$1",
        "/^locales\/(.*)$/": "<rootDir>/src/locales/$1",
    },
    "testMatch": [
        "**/*.{spec,test}.{js,jsx,ts,tsx}"
    ],
}
