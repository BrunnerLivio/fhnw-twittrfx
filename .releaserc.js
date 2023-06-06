module.exports = {
  branches: [
    "+([0-9])?(.{+([0-9]),x}).x",
    "master",
    "next",
    "next-major",
    { name: "beta", prerelease: true },
    { name: "alpha", prerelease: true },
  ],
  plugins: [
    "@semantic-release/commit-analyzer",
    "@semantic-release/release-notes-generator",
    [
      "@google/semantic-release-replace-plugin",
      {
        replacements: [
          {
            files: ["pom.xml"],
            from: '<version>0.0.0-VERSION</version>',
            to: '<version>${nextRelease.version}</version>',
            results: [
              {
                file: "pom.xml",
                hasChanged: true,
                numMatches: 1,
                numReplacements: 1,
              },
            ],
            countMatches: true,
          },
        ],
      },
    ],
    [
      "@semantic-release/git",
      {
        assets: ["pom.xml"],
      },
    ],
    [
      "@semantic-release-plus/docker",
      {
        name: process.env.IMAGE_NAME?.toLowerCase() || "twittrfx-server",
        registry: process.env.REGISTRY || "ghcr.io",
      },
    ],
    [
      "@semantic-release/github",
      {
        assets: [
          {
            path: "staging/*.jar",
            label: "TwittrFX Jar",
          },
        ],
      },
    ],
  ],
};
