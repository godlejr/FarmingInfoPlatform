const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const defaults = {
  entry: './src/main/webapp/resources/static/js/index.js',
  output: {
    path: path.join(__dirname, './src/main/webapp/resources/static/js'),
    filename: 'bundle.js',
  },
  
  module: {
    loaders: [{
      test: /\.js$/,
      exclude: /(node_modules|bower_components|public)/,
      loader: "babel",
      query:
      {
    	  cacheDirectory: true,
    	  presets:['es2015','react']
      }
    }, {
      test: /\.json$/,
      loader: 'json-loader'
    }],
  },
  
  resolve: {
    modulesDirectories: ['node_modules'],
    root: path.resolve('./src'),
    extensions: ['', '.js', '.jsx'],
  },
  
  plugins: [
    // Avoid publishing files when compilation fails
    new webpack.NoErrorsPlugin(),
    new webpack.ProvidePlugin({
      '$': 'jquery',
      'jQuery': 'jquery',
      'window.jQuery': 'jquery',
    }),
    // new HtmlWebpackPlugin({
    //   template: path.join(__dirname, './app/index.html'),
    //   filename: 'index.html',
    //   inject: 'body'
    // })
  ],
};

module.exports = defaults;
